package sample.demo.dao;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;
import sample.demo.entity.DomaDtoImpl;

@NoArgsConstructor // コンストラクタが必須のため
@Slf4j
public class DefaultEntityListener<ENTITY> implements EntityListener<ENTITY> {

  @Override
  public void preInsert(ENTITY entity, PreInsertContext<ENTITY> context) {
    // TODO 二重送信防止チェック
    // val expected = DoubleSubmitCheckTokenHolder.getExpectedToken();
    // val actual = DoubleSubmitCheckTokenHolder.getActualToken();

    // if (expected != null && actual != null && !Objects.equals(expected, actual)) {
    // throw new DoubleSubmitErrorException();
    // }
    if (entity instanceof DomaDtoImpl) {
      val domaDto = (DomaDtoImpl) entity;
      val createdAt = AuditInfoHolder.getAuditDateTime();
      val createdBy = AuditInfoHolder.getAuditUser();
      domaDto.setCreatedAt(createdAt);
      domaDto.setCreatedBy(createdBy);
    }
  }

  @Override
  public void preUpdate(ENTITY entity, PreUpdateContext<ENTITY> context) {
    if (entity instanceof DomaDtoImpl) {
      val domaDto = (DomaDtoImpl) entity;
      val createdAt = AuditInfoHolder.getAuditDateTime();
      val createdBy = AuditInfoHolder.getAuditUser();
      domaDto.setUpdatedAt(createdAt);
      domaDto.setCreatedBy(createdBy);
    }
  }

  @Override
  public void preDelete(ENTITY entity, PreDeleteContext<ENTITY> context) {
    if (entity instanceof DomaDtoImpl) {
      val domaDto = (DomaDtoImpl) entity;
      val deletedAt = AuditInfoHolder.getAuditDateTime();
      val deletedBy = AuditInfoHolder.getAuditUser();
      domaDto.setUpdatedAt(deletedAt);
      domaDto.setCreatedBy(deletedBy);
      // 物理削除した場合はログ出力する
      log.info("データを物理削除しました。 deletedBy={}, deletedAt={}", deletedBy, deletedAt);
    }
  }
}
