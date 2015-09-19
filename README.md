# Android-Loading-Google-Concept
A Simple Android Loading View with Google Concept.

# **How To use**
Copy **LoadingView.java** to the project.

In Layout xml,
```xml
 <com.scriptedpapers.androidloadinggoogleconcept.LoadingView
           android:id="@+id/loadingView"
           android:layout_width="300dp"
           android:layout_height="300dp"
           android:layout_centerInParent="true"/>
```

In View To Start Loading Progress,
```
           loadingView.setCurrentMode(LoadingView.START_MODE);
```

In View To Stop Loading Progress,
```
           loadingView.setCurrentMode(LoadingView.STOP_MODE);
```

# **Output**
![alt tag](https://github.com/maheswaranapk/Android-Loading-Google-Concept/blob/master/sample/Output.gif)
