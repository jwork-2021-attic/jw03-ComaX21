## 代码理解  
以BubbleSorter为例
代码可以分成两个部分理解：   
第一部分是编译BubbleSorter类产生字节码，然后将字节码隐写到给定的图片中，是利用SteganographyEncoder中的编码功能。  
第二部分是利用SteganographyEncoder中的解码功能，将第一部分中隐写进图片中的BubbleSorter类的字节码从隐写术图中解码出来，并用自定义的classloader将解码出来的BubbleSorter类的字节码加载到内存，然后将BubbleSorter交给Geezer对葫芦娃进行排序。  

下面分别解释两个部分的工作原理：  

第一部分：  
该部分从SteganographyFactory中的main函数开始运行，调用SteganographyFactory.getSteganography方法获得隐写术图  

在SteganographyFactory.getSteganography方法中，首先编译example/BubbleSorter.java产生.class的字节码文件，然后利用给定图片构造一个SteganographyEncoder的实例，最后调用SteganographyEncoder.encodeFile方法将BubbleSorter的字节码隐写到图片中  

下面解释最重要的SteganographyEncoder.encodeFile方法  
SteganographyEncoder.encodeFile方法负责生成名为finalbytes的byte数组，并传给SteganographyEncoder.encode方法  
SteganographyEncoder.encode方法负责将finalbytes数组最终编码到图片中  

finalbytes的格式：文件名长度|字节码长度|文件名|字节码  
其中文件名长度和字节码长度都是四个bytes，文件名和字节码根据文件名长度和字节码长度确定（理解这一点对于完成decode中的TODO非常重要） 

SteganographyEncoder.encode方法的编码方式：  
把每个pixel的每个颜色值字段的后两个比特位作为隐写位，每次把字节码的两个比特写入，每个pixel能够写入6个比特。

第二部分：
该部分从Scene中的main函数开始运行  
调用自定义的类加载器SteganographyClassLoader加载BubbleSorter类，改写SteganographyClassLoader的findClass方法，通过将调用类加载器时传入的图片解码获得BubbleSorter类。对于解码过程此处就不进行详细描述了，实际上就是第一部分中编码的逆过程。下面仅详细解释一下decode中TODO的实现：  
TODO要求decode过程可以从图片中解码需要的字节，而不是图片的全部字节。实际上就是在encode过程中，将字节码编码到图片中时，仅用了图片的一部分字节。要实现这一点也非常简单，就是首先解码出文件名长度和字节码长度，然后根据这两个值进行后续解码即可。
 


## QuickSorter(快速排序)隐写术图
![](https://github.com/jwork-2021/jw03-ComaX21/blob/main/example.QuickSorter.png)

## SelectSorter(选择排序)隐写术图
![](https://github.com/jwork-2021/jw03-ComaX21/blob/main/example.SelectSorter.png)

## 快排动画
[链接](https://asciinema.org/a/XXjaaSY3poWuZiIn10wPIAJYL)


## 选排动画
[链接](https://asciinema.org/a/HrnK4Ed69P70U3FofbLrwYfDJ)