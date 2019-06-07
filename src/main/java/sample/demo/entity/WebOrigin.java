package sample.demo.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WebOrigin extends DomaDtoImpl {

  private static final long serialVersionUID = 2399051382620886703L;

  // ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int clientId;

  // 値
  String value;

}
