Factory ってなに？
直訳すれば工場ですよね。
まぁ、実際に工場なんですけど、何の工場か？
もちろん、オブジェクト指向のハナシをしてるんですから、決まってますよね。オブジェクトです。

オブジェクトのインスタンスを、生成する工場なわけです。
a クラスのインスタンスを生成するための a ファクトリとか、x クラスのインスタンスを生成する x ファクトリとかなわけです。


それをやるとなにが嬉しいのか？
ファクトリを使用することで、オブジェクトのインスタンスを作る箇所での、依存度を下げることができるのです。

具体的に見てみましょう。
以下では、Java 風の擬似コードを使って説明していきます。
class A {
    // なにかの処理
}

class B {
    method(){
        A a = new A();
    }
}
この擬似コードでは、クラス B はクラス A に依存しています。
"A" というクラスを、そのまま変数の型に使用しているのと、A クラスのコンストラクタに直接アクセスしているからです。
なので、もし同じインタフェースを実装している別のクラスや、A クラスのサブクラスを作っても、クラス B の "method" メソッドを変更しないと、それに対応することはできません。


インタフェースで依存度を下げてみる
とりあえず、依存度を下げるための一歩として、インタフェースを用意しましょう。
interface C {
    // いくつかのメソッド
}
class A implements C {
    // インタフェースCの実装
}
クラスBは、以下のようになるでしょう。
class B {
    method(){
        C c = new A();
    }
}

しかし、これだけでは、依存度はたいして下がっていません。

問題なのは、 "new A();" の部分です。
根本的な問題は、コンストラクタへのアクセスにあるのです。


問題はコンストラクタ
コンストラクタの呼び出しを、コードのいろんなところに散りばめることは、コード全体に接着剤をぶちまけるようなものです。
アプリケーション全体が強力な依存性で接着されて、岩盤のように固く、変更困難になってしまいます。

"new A();" というコードがクラス B に書いてある限り、インタフェース C は依存度を下げる役には立ちません。
コンストラクタの呼び出しを、排除する必要があります。

でも、どこかしらでクラスを明示してコンストラクタを使用しなければ、オブジェクトを生成することはできませんね。
リフレクションでも使えば別ですが、それはそれで、多用するのは問題があります。


ファクトリを使って依存をなくす
コンストラクタの呼び出しが避けられないのなら、いっそ一箇所にまとめて隔離しましょう。
それがファクトリってわけです。
ファクトリを使うと、たとえばクラス B はこうなります。

class B {
    method(){
        C c = CFactory.newInstance();
    }
}

クラス A は、インタフェース C を実装しているとします。 CFactory は、newInstance() メソッド内で、クラス A のインスタンスを生成して返します。
クラス B からはクラス A のコンストラクタ呼び出しは排除され、CFactory の newInstance メソッド内に隠蔽されました。
これで、クラス B はインタフェース C を実装しているものならなんでも、変更なしに扱うことができます。

このクラスには、もはやクラスA の存在を匂わせるものは一切ありません。
実際、これが擬似コードでなく実装コードだったとしたら、この時点でクラス A のインポートステートメントも削除することができ、A というクラス名はもはやクラス B のソースから一切姿を消してしまうはずです。
このように、ファクトリを使用すれば単に依存度を下げることができるだけでなく、依存をまったくのゼロにすることができます。


ファクトリの可能性
上記のコードで出てきた CFactory は、単にコンストラクタを隠蔽しているだけでなく、実は大きな可能性を秘めています。
newInstance メソッドは、実際にクラス A を返すこともできますし、クラス A のサブクラスを返すこともできます。
あるいは、インタフェース C をインプリメントしているものの、クラス A とはまったく関係がないクラスを返すこともできます。
どのクラスを返すかは、クラス B とは関係のない、別のところで決めることができるのです。
クラス B を作ったときには想定していなかったクラスを、あとから追加して newInstance メソッドで返すようにすることができます。
これぞまさに自由!
実装上の自由というのは、依存性がゼロになったときにだけ生まれるものです。
インスタンス生成に自由をもたらすことが、ファクトリの目的です。

参考サイト
https://think-on-object.blogspot.com/2011/11/factoryfactory-methodabstract-factory.html