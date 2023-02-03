package dbfit.fixture;

import dbfit.api.DBEnvironment;
import dbfit.api.DbEnvironmentFactory;
import dbfit.util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dbfit.util.SymbolUtil.isSymbolGetter;

public class QueryCommonTableExpressionFromView extends Query {
	private String queryOrSymbol;
	private String view;

    public QueryCommonTableExpressionFromView() {
    	super();
    }
    
    public QueryCommonTableExpressionFromView(DBEnvironment environment, String view, String queryOrSymbol) {
    	super(environment, queryOrSymbol);
    }

}

