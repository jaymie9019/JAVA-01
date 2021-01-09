作业
1. 自己写一个简单的Hello.java，里面需要涉及基本类型，四则运算，if和for，然后自己分析一下对应的字节码

原文件见 src/task1/Hello.class

进入src目录

使用 javac 编译 `javac -g task1/Hello.java `

使用 javap 反编译 `javap -c -v task1.Hello`

得到以下字节码文件，注释写在 // 右侧

```text
Classfile /Users/jaymie/study/learn-java/JAVA-01/Week_01/src/task1/Hello.class // 从下一行开始的7行都是字节码文件信息
  Last modified 2021-1-9; size 901 bytes
  MD5 checksum 13c95fb96723e61efb2a2f4df116b49d
  Compiled from "Hello.java"
public class task1.Hello
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:  // 常量池
   #1 = Methodref          #6.#33         // java/lang/Object."<init>":()V
   #2 = Fieldref           #34.#35        // java/lang/System.out:Ljava/io/PrintStream;
   #3 = Methodref          #36.#37        // java/io/PrintStream.println:(I)V
   #4 = Fieldref           #5.#38         // task1/Hello.datas:[I
   #5 = Class              #39            // task1/Hello
   #6 = Class              #40            // java/lang/Object
   #7 = Utf8               datas
   #8 = Utf8               [I
   #9 = Utf8               <init>
  #10 = Utf8               ()V
  #11 = Utf8               Code
  #12 = Utf8               LineNumberTable
  #13 = Utf8               LocalVariableTable
  #14 = Utf8               this
  #15 = Utf8               Ltask1/Hello;
  #16 = Utf8               main
  #17 = Utf8               ([Ljava/lang/String;)V
  #18 = Utf8               num
  #19 = Utf8               I
  #20 = Utf8               args
  #21 = Utf8               [Ljava/lang/String;
  #22 = Utf8               a
  #23 = Utf8               b
  #24 = Utf8               c
  #25 = Utf8               max
  #26 = Utf8               sum
  #27 = Utf8               StackMapTable
  #28 = Class              #21            // "[Ljava/lang/String;"
  #29 = Class              #8             // "[I"
  #30 = Utf8               <clinit>
  #31 = Utf8               SourceFile
  #32 = Utf8               Hello.java
  #33 = NameAndType        #9:#10         // "<init>":()V
  #34 = Class              #41            // java/lang/System
  #35 = NameAndType        #42:#43        // out:Ljava/io/PrintStream;
  #36 = Class              #44            // java/io/PrintStream
  #37 = NameAndType        #45:#46        // println:(I)V
  #38 = NameAndType        #7:#8          // datas:[I
  #39 = Utf8               task1/Hello
  #40 = Utf8               java/lang/Object
  #41 = Utf8               java/lang/System
  #42 = Utf8               out
  #43 = Utf8               Ljava/io/PrintStream;
  #44 = Utf8               java/io/PrintStream
  #45 = Utf8               println
  #46 = Utf8               (I)V
{
  public task1.Hello();   // 构造方法
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1  // 最大操作栈1，局部变量表容量1，参数个数1
         0: aload_0                           // 将第一个引用类型本地变量推送至栈顶。对于非静态方法，this 会被分配到局部变量表的第0号槽位
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V  使用了父类Object的构造方法
         4: return
      LineNumberTable:  // 源码和字节码行数对应关系
        line 6: 0
      LocalVariableTable:  // 局部变量表
        Start  Length  Slot  Name   Signature
            0       5     0  this   Ltask1/Hello;

  public static void main(java.lang.String[]);  // main方法
    descriptor: ([Ljava/lang/String;)V          // 方法描述，L为对象，入参为String类型的对象，V表示方法返回为void
    flags: ACC_PUBLIC, ACC_STATIC               // 方法的访问标志，public 与 static
    Code:
      stack=2, locals=10, args_size=1           // 最大操作栈2，局部变量表容量10，参数1
         0: iconst_1                            // 将常量 1 压入栈顶，（i表示 int类型的数据，当int取值-1~5时，JVM采用iconst指令将常量压入栈中)
         1: istore_1                            // pop 出栈顶的 int类型的值，即1，存入到局部变量表的 slot1 位置，即slot1的值为1
         2: sipush        200                   // 将常量200压入栈顶， (当int取值-32768~32767时，JVM采用sipush指令将常量压入栈中。)
         5: istore_2                            // 将栈顶的元素pop出，存入到局部变量的 slot2 位置，即slot2的值为200
         6: iload_1                             // 将局部变量表的slot1压入栈，即1
         7: iload_2                             // 将局部变量表的slot2压入栈，即200
         8: iadd                                // 将栈顶两个元素pop之后相加，结果压入栈顶，结果为201
         9: istore_3                            // pop出栈顶的值201，存入到局部变量表的slot3
        10: getstatic     #2                    // Field java/lang/System.out:Ljava/io/PrintStream; 获取静态成员PrintStream，压入栈顶（#2对应常量池）
        13: iload_3                             // 将局部变量表slot3的值压入栈，即201
        14: invokevirtual #3                    // Method java/io/PrintStream.println:(I)V 调用实例方法 pringln 执行打印操作（#3页对应常量池中的方法）
        17: iconst_0                            // 常量0压入栈，并且存入到局部变量表的slot4
        18: istore        4
        20: iload_1                             // 将局部变量表的slot1和slot2压入栈，即 1 和 200
        21: iload_2
        22: if_icmple     31                   // 进行比较 如何1小于等于200，那么到31行指令，该条件成立（可以发现他的比较和源码是反着的，并且这个比较操作原本压入栈顶的两个元素也会进行出栈操作，这样子栈就是空的了）
        25: iload_1
        26: istore        4
        28: goto          34
        31: iload_2                            // 往栈顶压入slot2的值即 200
        32: istore        4                    // 将 200 存入到 slot4，slot4需要存放的是比较之后较大的那个值
        34: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream; 接下来和上面一样就行 slot4的值的打印操作
        37: iload         4
        39: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
        42: iconst_0                          // 常量0压入栈，并且存入到局部变量表的slot5, slot5需要最后存累加的结果
        43: istore        5                   
        45: getstatic     #4                  // Field datas:[I 从常量池活动 datas 数组的引用值（即#4），压入栈顶
        48: astore        6                   // 保存引用值到局部变量表的slot6，之后可以认为 slot6就是这个数组
        50: aload         6                   // 再次将数组压入到栈
        52: arraylength                       // 获取数组的长度，压入栈
        53: istore        7                   // 将栈顶的值存入到局部变量表的slot7，即数组的长度4，之后slot7可以认为是4
        55: iconst_0                          // 将常量0压入栈，然后出栈存入到slot8，可以认为是循环的临时变量 i
        56: istore        8                   
        58: iload         8                   // 将slot8，也就是i=0压入栈
        60: iload         7                   // 将slot7，也就是数组长度length=4压入栈
        62: if_icmpge     85                  // 进行比较，如果 0 >= 4 ，那么直接跳转到 85 行，显然不成立，则进入循环体内
        65: aload         6                   // 再次将 slot6 即数组的压入栈
        67: iload         8                   // 将slot8，也就是i=0压入栈
        69: iaload                            // 将int型数组指定索引的值推送至栈顶，就是将 datas[0] 压入栈，此时值为1
        70: istore        9                   // 出栈之后保存到临时变量表的 slot9 中，
        72: iload         5                   // slot5入栈，slot5为sum的值，此时为0
        74: iload         9                   // 再次把slot9入栈，为 datas[0]的值，此时为1，
        76: iadd                              // 栈顶两个元素相加，即 sum + datas[0], 得到的结果再次保存到 slot5中                 
        77: istore        5
        79: iinc          8, 1                // 将局部变量表的 slot8 也就是循环的临时表 i 进行 +1 操作，此时等于1
        82: goto          58                  // 跳转到 58 行继续循环逻辑
        85: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream; // 最后将slot5也就是sum的值进行pring输出
        88: iload         5
        90: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
        93: return
      LineNumberTable:   // 源码和字节码行数对应关系
        line 10: 0
        line 11: 2
        line 12: 6
        line 13: 10
        line 16: 17
        line 17: 20
        line 18: 25
        line 20: 31
        line 22: 34
        line 25: 42
        line 26: 45
        line 27: 72
        line 26: 79
        line 29: 85
        line 31: 93
      LocalVariableTable:   // 局部变量表
        Start  Length  Slot  Name   Signature
           72       7     9   num   I                    // slot9 存的是 num，也就是 datas[i]
            0      94     0  args   [Ljava/lang/String;  // slot0为该方法的入参
            2      92     1     a   I                    // slot1 为a的值
            6      88     2     b   I                    // slot2 为b的值
           10      84     3     c   I                    // slot3 为c的值
           20      74     4   max   I                    // slot4 为max
           45      49     5   sum   I                    // slot5 为sum
           // 之前可以看到局部变量表容量10，那么现在还缺少3个slot，slot6 保存了 datas 数组的引用值， slot7 数组的长度, slot8 循环的临时变量i
      StackMapTable: number_of_entries = 4
        frame_type = 255 /* full_frame */
          offset_delta = 31
          locals = [ class "[Ljava/lang/String;", int, int, int, int ]
          stack = []
        frame_type = 2 /* same */
        frame_type = 255 /* full_frame */
          offset_delta = 23
          locals = [ class "[Ljava/lang/String;", int, int, int, int, int, class "[I", int, int ]
          stack = []
        frame_type = 248 /* chop */
          offset_delta = 26

  static {};   // 初始化静态成员变量 datas 的逻辑
    descriptor: ()V
    flags: ACC_STATIC
    Code:
      stack=4, locals=0, args_size=0
         0: iconst_4
         1: newarray       int
         3: dup
         4: iconst_0
         5: iconst_1
         6: iastore
         7: dup
         8: iconst_1
         9: iconst_2
        10: iastore
        11: dup
        12: iconst_2
        13: bipush        10
        15: iastore
        16: dup
        17: iconst_3
        18: sipush        200
        21: iastore
        22: putstatic     #4                  // Field datas:[I
        25: return
      LineNumberTable:
        line 7: 0
}
SourceFile: "Hello.java"


```

2. 自定义一个 Classloader，加载一个Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节(x=255-x) 处理后的文件

详见 /srce/task2 中的部分代码

3. 画一张图，展示 Xmx， Xms，Xmn，Metaspace，DirectMemory，Xss 这些内存参数的关系

![img.png](img.png)


4. 检查一下自己维护的业务系统的 JVM 参数配置，用 jstat 和 jstack，jmap 查看下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改机
    * 对于线上有流量的系统，慎重使用jmap命令
    * 如果没有线上系统，可以自己 run 一个 web/java 项目，或者查看idea进程
   
晚点再做

    
