package sample.demo.entity;

/** ページング可能であることを示す */
public interface Pageable {

  Pageable DEFAULT = new DefaultPageable(1, 10);

  Pageable NO_LIMIT = new DefaultPageable(1, Integer.MAX_VALUE - 1);

  /** @return */
  int getPage();

  /** @return */
  int getPerpage();
}
