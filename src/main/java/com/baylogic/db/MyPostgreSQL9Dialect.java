package com.baylogic.db;

import org.hibernate.dialect.PostgreSQL94Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
 
public class MyPostgreSQL9Dialect extends PostgreSQL94Dialect {
 
    public MyPostgreSQL9Dialect() {
        super();
        registerFunction("doc_list_by_search", new StandardSQLFunction("doc_list_by_search"));
    }
}