package nl.whitehorses.fcforms.shell.backing;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import nl.whitehorses.fcforms.tasks.entities.FcTask;

import oracle.ui.pattern.dynamicShell.TabContext;

public class Launcher
{
 

    public void multipleTaskActivity(String taskId,FcTask task)
    {

        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("inputTask",taskId);
        parameterMap.put("task",task);

// change me with real values
        if ( task.getUrl() == null) {
          parameterMap.put("inputIframeUrl","http://www.amis.nl");
        } else {
            parameterMap.put("inputIframeUrl",task.getUrl());   
        }
        parameterMap.put("user","weblogic");
       
        _launchActivity(
        "Task "+task.getTaskNumber(),
        "/WEB-INF/flows/detail.xml#detail",
        true,
        parameterMap);
    }

 
  public void closeCurrentActivity(ActionEvent actionEvent)
  {
    TabContext tabContext = TabContext.getCurrentInstance();
    int tabIndex = tabContext.getSelectedTabIndex();
    if (tabIndex != -1)
    {
      tabContext.removeTab(tabIndex);
    }
  }
 
    public void currentTabDirty(ActionEvent e)
    {
        /**
        * When called, marks the current tab "dirty". Only at the View level
        * is it possible to mark a tab dirty since the model level does not
        * track to which tab data belongs.
        */
      TabContext tabContext = TabContext.getCurrentInstance();
      tabContext.markCurrentTabDirty(true);
    } 
 
    public void currentTabClean(ActionEvent e)
    {
      TabContext tabContext = TabContext.getCurrentInstance();
      tabContext.markCurrentTabDirty(false);
    }
   
    public void checkState(boolean isDirty) {
      /**
      * Example method to call prior to page navigation to determine if
      * any tab has been marked as dirty. If true, a popup dialog in the
      * current page can be called to warn the user of unsaved data.
      */
      TabContext tabContext = TabContext.getCurrentInstance(); 
      boolean isAnyTabDirty = tabContext.isTagSetDirty();
      if (tabContext != null && isAnyTabDirty) {
          // return and warn user in popup dialog from page
        isDirty = isAnyTabDirty;
        return;
      }
      else {
          isDirty = isAnyTabDirty;
      return;
    }
  }
   
  private void _launchActivity(String title, String taskflowId, boolean newTab, Map<String,Object> parameters)
  {
    try
    {
      if (newTab)
      {
        TabContext.getCurrentInstance().addTab(
          title,
          taskflowId,
          parameters);
      }
      else
      {
        TabContext.getCurrentInstance().addOrSelectTab(
          title,
          taskflowId,
          parameters);
      }
    }
    catch (TabContext.TabOverflowException toe)
    {
      // causes a dialog to be displayed to the user saying that there are
      // too many tabs open - the new tab will not be opened...
      toe.handleDefault(); 
    }
  }

    public static Object getFromRequest(String key) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getRequestMap();
        return sessionState.get(key);
    }
    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

}