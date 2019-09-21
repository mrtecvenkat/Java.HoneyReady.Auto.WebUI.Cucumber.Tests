package core;

import core.helper.TestKeywords;

public class Reporter {
    public boolean showDebugMessages=true;
    private enum REPORT_TYPE{
        INFO,
        ERROR,
        WARNING,
        DEBUG;
    }
    private UtilHelper utilHelper;
    public Reporter(){
        utilHelper = new UtilHelper();
    }
    public void logInfo(String message){
        System.out.println(REPORT_TYPE.INFO+">>"+utilHelper.getCURRENT_TIME_STAMP()+">>"+message);
    }
    public String logError(String message){
        String retval=REPORT_TYPE.ERROR+">>"+utilHelper.getCURRENT_TIME_STAMP()+">>"+message;
        System.out.println(retval);
        return retval;
    }
    public String logWarning(String message){
        String retval=REPORT_TYPE.WARNING+">>"+utilHelper.getCURRENT_TIME_STAMP()+">>"+message;
        System.out.println(retval);
        return retval;
    }
    public String logDebug(String message){
        String retval=REPORT_TYPE.DEBUG+">>"+utilHelper.getCURRENT_TIME_STAMP()+">>"+message;
        System.out.println(retval);
        return retval;
    }

    public void logInfo(TestKeywords.Action actionName,TestKeywords.Selecots selector, String selectorValue){
        System.out.println(REPORT_TYPE.INFO+">>"+utilHelper.getCURRENT_TIME_STAMP()+">>"+actionName+" on "+selector+"("+selectorValue+")");
    }
    public String logError(TestKeywords.Action actionName,TestKeywords.Selecots selector, String selectorValue, String message){
        String retval=REPORT_TYPE.ERROR+">>"+utilHelper.getCURRENT_TIME_STAMP()+">>"+actionName+" on "+selector+"("+selectorValue+")" + message;
        System.out.println(retval);
        return retval;
    }
    public String logWarning(TestKeywords.Action actionName,TestKeywords.Selecots selector, String selectorValue, String message){
        String retval=REPORT_TYPE.WARNING+">>"+utilHelper.getCURRENT_TIME_STAMP()+">>"+actionName+" on "+selector+"("+selectorValue+")" + message;
        System.out.println(retval);
        return retval;
    }
    public String logDebug(TestKeywords.Action actionName,TestKeywords.Selecots selector, String selectorValue, String message){
        String retval=REPORT_TYPE.DEBUG+">>"+utilHelper.getCURRENT_TIME_STAMP()+">>"+actionName+" on "+selector+"("+selectorValue+")" + message;
        System.out.println(retval);
        return retval;
    }

}
