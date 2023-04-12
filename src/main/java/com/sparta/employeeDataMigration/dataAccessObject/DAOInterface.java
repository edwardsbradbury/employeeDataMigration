package com.sparta.employeeDataMigration.dataAccessObject;

import java.util.List;

public interface DAOInterface<T> {

  int insert (T newRow);
  List<T> getAll();
}
