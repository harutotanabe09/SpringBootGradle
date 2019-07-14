#　技術のTips

## 各メソッドについて、Abstractのクラスを持つ
###   例）Controller、Service

## Entityとシリアライズ
### 各エンティティには一意になる情報を設定する

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

## Logging
### @Slf4jで以下のloggerを自動生成できる
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

## gitignore
### 一時ファイルを除く
### logファイルとクラスファイルを除く
### https://github.com/github/gitignore

## Swagger (API)
### swagger-ui.htmlで出力

http://localhost:8079/swagger-ui.html

## Get API by Spring

RestTemplateが使える。クラスに指定したURLと戻り値を設定する方法

## Spring Retry

Try Catcheをリトライして書く必要がない、
ConfigファイルとAnottaionファイルで実行する方法

## コネクションプールの設定

コネクションプールは、一度通過したらそのキャッシュ情報を使用する

## コード整形
### gradle spotlessApplyを実行すると可能

## Javadoc
### gradle javadocを実行して表示

###  アプリケーションレイヤー

### アプリケーション層

#### Controller
リクエストの処理を返す。ビジネスロジックと持たない。
コントローラからサービスを呼び、サービスがロジックを持つ。
FatControllerは悪。

#### View
PDF,Excelなどの出力結果を返す

#### Form
画面のフォームを表現する。
JavaBeanで、アノテーションで制約事項（型チェックなど）を記載する

### ドメイン層

#### Entity（人によってはDto）
DBのテーブルの1レコードを表現する
例）PersonテーブルのNameやBirthdateなど

#### Dao（人によってはRepository）
データのアクセス処理を行う。
例）DBのCRUD処理

#### Service
業務処理（ビジネスロジック）を行う。
またServiceからServiceクラスを呼ばない。
例）Daoの呼び出し

### マルチプロジェクト

#### settings.gradle
シェアするプロジェクト名を記載

includeFlat 'share'


#### build.gradle
シェアする情報を記載

subprojects{

}

dependencies{
	compile project(":share")
}

★最後にbuild eclipseを実行

#### Actuator

プロパティで設定。以下URL実行。

http://localhost:8079/actuator/heapdump

Actuator

curl 'http://localhost:8079/actuator/heapdump' -O

#### Actuator & Prometheus

Prometheus連携のためにGradleを追加。（io.micrometer）

curl 'http://localhost:8079/actuator/prometheus' -i -X GET


### Dockerのネットワーク使い方

コンテナ間同士のネットワーク通信

・ネットワーク作成
sudo docker network create -d bridge my-network

・ネットワーク確認
sudo docker network inspect my-network

・ネットワーク追加（networkとnet-aliasが必要）
sudo docker run --name myjava --rm -p 8080:8080 --network my-network --net-alias java my-java

・他コンテナの参照名は、net-aliasの名前になる。

sudo docker run --name my-prometheus --rm -p 9090:9090 --network my-network --net-alias my-prometheus my-prometheus
・DockerComponentはServiceで上記を自動生成する

