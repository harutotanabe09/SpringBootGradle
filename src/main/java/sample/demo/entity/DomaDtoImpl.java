package sample.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Version;
import sample.demo.controller.api.resource.Dto;
import sample.demo.dao.DefaultEntityListener;

@SuppressWarnings("serial") // SerializeしないとNG
@Entity(listener = DefaultEntityListener.class) // 自動的にシステム制御項目を更新するためにリスナーを指定する
@Setter
@Getter
public abstract class DomaDtoImpl implements Dto, Serializable {

  // 作成者
  String createdBy;

  // 作成日時
  LocalDateTime createdAt;

  // 更新者
  String updatedBy;

  // 更新日時
  LocalDateTime updatedAt;

  // 削除者
  String deletedBy;

  // 削除日時
  LocalDateTime deletedAt;

  // 楽観的排他制御で使用する改定番号
  @Version
  @Column(name = "version")
  Integer version;
}
