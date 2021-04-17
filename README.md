# xException

Exception handler for Android.

## Installation

Add it in your root build.gradle at the end of repositories:

```bash
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```bash
implementation 'com.github.ResulSilay:xException:1.0.0'
```

## Usage

```java
CrashHandler.init { timeMillis: Long, thread: Thread, throwable: Throwable ->

}
```

## Example
```java
class ExceptionApp : Application() {

    override fun onCreate() {
        super.onCreate()

        CrashHandler.init { timeMillis: Long, thread: Thread, throwable: Throwable ->
            write(applicationContext, "logger", "$timeMillis --> ${thread.name}: ${getStackTraceString(throwable)}")
        }
    }
}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
