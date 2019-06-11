#　技術のTips

## 各メソッドについて、Abstractのクラスを持つ
###   例）Controller、Service

## JavaBeanの実装
###   @Lombokを使用し @Getter,@Setterで宣言する

## Utilsのクラスのメソッドは、staticのメソッドを使用する
### 使用時にimport saticで呼び出す

## Factory パターンを使用
###   インスタンスの生成をサブクラスに行わせる
###   例）ResourceFactory

## Confの定数はinterfaceクラスの中にメンバを持つ
### interfaceクラスのメンバ変数は「static final」が省略された形
### 使用時にimport saticで呼び出す

## @Slf4j
### 以下のloggerを自動生成できる
### private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BusinessLogic1.class);

## NULLチェック
### サービスクラスなどで行う。
### Assert.notNull(id, "id must not be null");
### org.springframework.util.Assertを使用する
### 文字列のNULLチェック
### StringUtils.isEmpty()

## Doma
### SQLファイルはresources配下する必要あり

## Junit
## gradle testで実行。テスト結果はHTMLファイルで出力。(/build/	report/tests/)


