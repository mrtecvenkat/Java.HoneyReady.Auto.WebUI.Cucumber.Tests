package core.helper;

import org.omg.CORBA.PUBLIC_MEMBER;

public interface TestKeywords {

    public String BASE_PATH="";

    public enum BrowserList{
        CHROME_BROWSER,
        IE_BROWSER,
        FIREFOX_BROWSER;
    }
    public enum OSList{
        OS_WINDOWS,
        OS_LINUX;

    }
    public enum Selecots{
            ID,NAME,XPATH,CSSSELECTOR,CLASSNAME,TAGNAME,LINKTEXT,PARTIALLLINKTEXT;
    }

    public interface BaseFolderName{

        public String INPUT="test-input";
        public String OUTPUT="test-output";
        public String RESOURCE="test-resourse";
    }

    public interface ReportFolderName{
        public String TEXT_REPORT="core-text-report";
        public String EXCEL_REPORT="core-excel-report";
        public String WORD_REPORT="core-workd-report";
        public String XML_REPORT="core-xml-report";
        public String HTML_REPORT="core-html-report";
    }

    public interface ReportName{
        public String TEXT_REPORTER="text_report";
        public String EXCEL_REPORTER="excel_report";
        public String WORD_REPORTER="word_report";
        public String XML_REPORTER="xml_report";
        public String HTML_REPORTER="html_report";
    }
    public enum  Action{
        OPEN,CLICK,SET,SELECT,VERIFY,STORE,MAXIMIZE,SWITCH_TO_WINDOW,SWITCH_BACK_TO_WINDOW,
        SWITCH_TO_FRAME,HANDLE_ALERT,GET_ALERT_TEXT,CLOSE,EXIT,REOPEN,RUN_SCRIPT,EVAL;
    }

    public interface DataType{

        public String EMPTY="";
        public String NULL="null";
    }
    public interface ErrorType{

        public String PASS="PASS";
        public String FAIL="FAIL";
        public String ERROR="ERROR";
        public String WARNING="WARNING";
    }

    public interface ColumnName{

        public String RECORD_ID="RECORD_ID";
        public String RUN_FLAG="RUN_FLAG";
        public String PROJECT_ID="PROJECT_ID";
        public String PROJECT_NAME="PROJECT_NAME";
        public String FEATURE_ID="FEATURE_ID";
        public String FEATURE_NAME="FEATURE_NAME";
        public String USER_STORY_ID="USERSTORY_ID";
        public String USER_STORY_NAME="USERSTORY_NAME";
        public String TEST_CASE_ID="TESTCASE_ID";
        public String TEST_CASE_NAME="TESTCASE_NAME";
        public String ITERATION_ID="ITERATION_ID";
        public String COMMAND="COMMAND";
        public String TARGET="TARGET";
        public String VALUE="VALUE";
        public String DATA_KEY="KEY";
        public String DATA_VALUE="VALUE";
        public String RUN_RESULTS="RUN_RESULTS";
        public String RUN_DESCRIPTION="RUN_DESCRIPTION";
        public String RUN_START_TIME="RUN_START_TIME";
        public String RUN_END_TIME="RUN_END_TIME";
        public String RUN_TOTAL_TIME="RUN_TOTAL_TIME";
    }

    public interface TableNames{
        public String TEST_CASES="TestCases";
        public String ITERATION_MAP="TestCaseIterationMap";
        public String GLOBAL_DATA="GlobalData";
        public String TEST_DATA="TestData";
    }

}

