package sample.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Entity;

@Entity
@Getter
@Setter
public class Fine extends DomaDtoImpl {

  int number;

  String name;

  String adress;

  String date;
}
