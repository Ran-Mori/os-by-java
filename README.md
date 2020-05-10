# OS-by-Java
## 计算机操作系统实验课 Java编写

### 实验一 —— 按照优先数进行处理器调度
  * 一共分了3个包，**code包**是主要代码，**main包**是主函数，**test包**用于测试.
  * code包下
      * **Process类**属性即进程的基本属性，如***name,runningTime,priorty***.
      * **CPU类**是此项目的重点类，它有一个**线性表**用于存放所有的进程，**addProcess**()用于添加进程，但要根据优先度进行排序，接着就是调度**schedule**()方法，基本操作就是将就绪队列最前面的进程运行时间和优先度分别递减，如果运行结束就抽出队列.
  * Main包下
      * 主函数主要通过获得键盘输入作为进程的参数创建所需进程，接着**while循环**进行调度，直到队列为空为止。中间使用线程进行时间等待，以不至于一开始就打印出所有结果
  * Test包
      * 需要Juint引入测试框架
  * Utiles类
      * 一个**静态工具类**，其中有获取键盘参数创建进程的方法.
******************************************************
### 实验二 —— 首次适应算法分区管理
  * 本实验一共分为3个包，分别是code,main,test
  * code包
      * Memory类 重要属性有**分区块列表**，用于保存分区块；方法有**排序方法**()，把分区块列表按照首地址排序
      * MemoryBlock类 重要属性有**start,end,length,task,isUsed**,其中**task**属性用于保存此分区块属于那个任务，**isUsed**标记是否是空分区块
    重要方法是实现Comparable接口的方法，按照**start**属性排序
      * MemoryOperator类 无重要属性，重要方法有**添加任务申请分区，撤销任务擦除分区，合并邻近分区**，其中**撤销任务擦除分区**()会涉及**调用合并邻近分区**。另外方法是**打印内存的分区情况**
      * Task类 重要属性只有**分区大小**
   * main包 
      * 只有主类和主函数，通过键盘获取**整数输入**，使用**while死循环，swich**实现题目要求逻辑
   * test包 
      * 需要引入Juint测试框架，用于测试编写中的类
**************************************
### 实验四 —— 进程创建
   * 只有一个main函数。根据**fork函数**的返回值来判断是父进程还是子进程，从而执行相应的操作
   * 操系统为deepin OS, IDE为Clion
******************************************************
### 实验五 —— 模拟银行家算法
  * 本实验一共分为3个包，分别是code,main,test
  * code包
      * BankerAlgorithm类 
          * 属性**alocation二维数组**，用于保存每个进程已分配的各种资源的数目。
          * 属性**need二维数组**，用于保存每个进程还需要的各种资源的数目。
          * 属性**work一维数组**，用于验证是否安全，假设某个进程执行结束，则收回分配的资源，类似拓扑结构判断是否死锁。
          * 方法**askForResources(int id, int[] request)**，输入进程序号以及请求资源的数目。返回是否请求成功。
          * 方法**public boolean isSafe()**，用于判断分配资源后是否会出现死锁。在askForResources(int id, int[] request)中嵌套使用，作为其方法体一部分。
      * Utils类 
          * 一个静态工具类。主要实现**一维和二维数组的相加相减**，**数组的格式化输出**，**从键盘获取输入确定askForResources(int id, int[] request)的参数**
   * main包 
      * 只有主类和主函数，通过键盘获取**整数输入**，按照示例实现算法演示
   * test包 
      * 需要引入Juint测试框架，用于测试编写中的类。


