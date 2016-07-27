package com.capgemini.devonfw.chirr.messagemanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.capgemini.devonfw.chirr.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.capgemini.devonfw.chirr.messagemanagement.dataaccess.api.MessageEntity;
import com.capgemini.devonfw.chirr.messagemanagement.dataaccess.api.dao.MessageDao;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.to.MessageSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link MessageDao}.
 */
@Named
public class MessageDaoImpl extends ApplicationDaoImpl<MessageEntity> implements MessageDao {

  /**
   * The constructor.
   */
  public MessageDaoImpl() {

    super();
  }

  @Override
  public Class<MessageEntity> getEntityClass() {

    return MessageEntity.class;
  }

  @Override
  public PaginatedListTo<MessageEntity> findMessages(MessageSearchCriteriaTo criteria) {

    MessageEntity message = Alias.alias(MessageEntity.class);
    EntityPathBase<MessageEntity> alias = Alias.$(message);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String content = criteria.getContent();
    if (content != null) {
      query.where(Alias.$(message.getContent()).eq(content));
    }
    Long flowid = criteria.getFlowid();
    if (flowid != null) {
      query.where(Alias.$(message.getFlowid()).eq(flowid));
    }
    Long userid = criteria.getUserid();
    if (userid != null) {
      query.where(Alias.$(message.getUserid()).eq(userid));
    }
    return findPaginated(criteria, query, alias);
  }

}