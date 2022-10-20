package Repositories;

import Fourteam.http.Exception.HttpException;

public interface IUnitOfWork {
  public void commit() throws HttpException, Exception;
}
