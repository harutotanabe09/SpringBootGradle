package sample.demo.entity;

import org.seasar.doma.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Fine extends DomaDtoImpl {

  int number;

  String name;

  String adress;

  String date;

}
