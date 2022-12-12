package dbfit.fixture;

import dbfit.api.DBEnvironment;
import dbfit.util.NoMatchingRowFoundException;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;

public class QueryCommonTableExpressionFromView extends Query {

    public QueryCommonTableExpressionFromView(DBEnvironment environment, String view, String queryForCommonTableExpression, String userName) throws SQLException, NoMatchingRowFoundException {
        super(environment,null);
        Query viewTableQuery = new Query(environment,"select DBMS_METADATA.GET_DDL('VIEW','" + view + "','" + userName + "') text from dual");
        String finalQueryExpression = viewTableQuery.getDataTable().findFirstUnprocessedRow().getStringValue("text");
        finalQueryExpression = "with " + StringUtils.substringAfter(finalQueryExpression,"with");
        finalQueryExpression = finalQueryExpression.replace("--FINAL SELECT",", final_select as (") + ") " + queryForCommonTableExpression;
        super.setQueryOrSymbol(finalQueryExpression);
    }

}
