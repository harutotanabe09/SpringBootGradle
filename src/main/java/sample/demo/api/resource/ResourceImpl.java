package sample.demo.api.resource;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import sample.demo.controller.api.resource.Dto;
import sample.demo.controller.api.resource.Resource;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceImpl implements Resource {

  List<? extends Dto> data;

  // メッセージ
  String message;
}
