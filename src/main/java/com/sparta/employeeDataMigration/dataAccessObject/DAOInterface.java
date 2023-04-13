package com.sparta.employeeDataMigration.dataAccessObject;

import java.util.List;

public interface DAOInterface<T> {

  boolean insert (T newRow);
  List<T> getAll();
}
