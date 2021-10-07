### 代码理解  
代码可以分成两个部分理解：   
第一部分是编译给定的Sorter类产生字节码，然后将字节码隐写到给定的图片中，是利用SteganographyEncoder中的编码功能。  
第二部分是利用SteganographyEncoder中的解码功能，将第一部分中隐写进图片中的Sorter类的字节码从隐写术图中解码出来，  
并用自定义的classloader将解码出来的Sorter类的字节码加载到内存，然后将该Sorter类交给Geezer对葫芦娃进行排序。  

下面分别解释两个部分的工作原理：  

第一部分：  
该部分从SteganographyFactory.class中的main函数开始运行，调用SteganographyFactory.getSteganography方法获得隐写术图
在SteganographyFactory.getSteganography方法中

### QuickSorter(快速排序)隐写术图
![](https://github.com/jwork-2021/jw03-ComaX21/blob/main/example.QuickSorter.png)

### SelectSorter(选择排序)隐写术图
![](https://github.com/jwork-2021/jw03-ComaX21/blob/main/example.SelectSorter.png)

### 快排动画
[](https://asciinema.org/a/XXjaaSY3poWuZiIn10wPIAJYL)

### 选排动画
[](https://asciinema.org/a/HrnK4Ed69P70U3FofbLrwYfDJ)