package com.capgemini.devon.chirr.general.dataaccess.base.dao;

import com.capgemini.devon.chirr.general.dataaccess.api.BinaryObjectEntity;
import com.capgemini.devon.chirr.general.dataaccess.api.dao.BinaryObjectDao;

import javax.inject.Named;

/**
 * Implementation of {@link BinaryObjectDao}.
 *
 * @author sspielma
 */
@Named
public class BinaryObjectDaoImpl extends ApplicationDaoImpl<BinaryObjectEntity> implements BinaryObjectDao {

  @Override
  public Class<BinaryObjectEntity> getEntityClass() {

    return BinaryObjectEntity.class;
  }

}
