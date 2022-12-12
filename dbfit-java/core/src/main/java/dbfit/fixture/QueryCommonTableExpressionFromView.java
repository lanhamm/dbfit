package dbfit.fixture;

import dbfit.api.DBEnvironment;
import dbfit.util.NoMatchingRowFoundException;

import java.sql.SQLException;

public class QueryCommonTableExpressionFromView extends Query {

    public QueryCommonTableExpressionFromView(DBEnvironment environment, String view, String queryForCommonTableExpression) throws SQLException, NoMatchingRowFoundException {
        super(environment,null);
        Query viewTableQuery = new Query(environment,"select TEXT_VC from user_views where view_name = '" + view + "'");
        String finalQueryExpression = viewTableQuery.getDataTable().findFirstUnprocessedRow().getStringValue("text_vc");
        finalQueryExpression = finalQueryExpression.replace("--FINAL SELECT",", final_select as (") + ") " + queryForCommonTableExpression;
        super.setQueryOrSymbol(finalQueryExpression);
    }

}
