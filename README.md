# Android Test Framework Using Appium

This framework is designed for automated testing of Android applications using Java and Appium. It provides a structured
approach to create and execute tests for Android apps using Cucumber for feature-driven development.

## Requirements

To set up and run this framework, ensure you have the following tools installed:

- **Node v16.13.0 / 18.0.0+** : Runtime JS for development.
- **NPM v8+** : Node Package Manager for installing Appium.
- **IntelliJ IDE**: Recommended IDE for development.
- **Java 17**: Required runtime for the project.
- **UIAutomator2** : Required for Driver. 
- **Android Studio** (latest version): Includes Android SDK and necessary emulators.
- **Appium**: For automating mobile applications.
- **Appium Doctor** (optional): Useful for diagnosing environment issues.
- **Appium Inspector** (optional): Helps in selecting UI elements for test scripts.

### Setting Up Environment Variables

Both `JAVA_HOME` and `ANDROID_HOME` need to be set to ensure compatibility with Android Studio and Appium.

#### macOS

1. **Set `JAVA_HOME`**:
    - Find your Java installation path (e.g., `/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home`).
    - Open a terminal and add the following line to your shell profile file (`~/.zshrc` for Zsh or `~/.bash_profile` for
      Bash):
      ```bash
      export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home
      ```
    - Apply the changes:
      ```bash
      source ~/.zshrc  # or source ~/.bash_profile
      ```

2. **Set `ANDROID_HOME`**:
    - Locate your Android SDK path, typically at `~/Library/Android/sdk`.
    - Add the following lines to your shell profile file:
      ```bash
      export ANDROID_HOME=~/Library/Android/sdk
      export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
      ```
    - Apply the changes:
      ```bash
      source ~/.zshrc  # or source ~/.bash_profile
      ```

#### Windows

1. **Set `JAVA_HOME`**:
    - Go to the Control Panel > System and Security > System > Advanced System Settings > Environment Variables.
    - Under **System Variables**, click **New** and set:
        - **Variable name**: `JAVA_HOME`
        - **Variable value**: Path to your JDK, e.g., `C:\Program Files\Java\jdk-17`.
    - Click **OK** and apply the changes.

2. **Set `ANDROID_HOME`**:
    - Go to the Control Panel > System and Security > System > Advanced System Settings > Environment Variables.
    - Under **System Variables**, click **New** and set:
        - **Variable name**: `ANDROID_HOME`
        - **Variable value**: Path to your Android SDK, e.g., `C:\Users\YourUsername\AppData\Local\Android\Sdk`.
    - Add the following to the **Path** variable under **System Variables**:
      ```plaintext
      %ANDROID_HOME%\tools
      %ANDROID_HOME%\platform-tools
      ```
    - Click **OK** and restart your terminal or IDE.

#### Linux (Tested on Debian)

1. **Set `JAVA_HOME`**:
   - (Optional - if you dont know the path) Open terminal and type `readlink -f $(which java)`. It will print path of your java, so copy it.
   - On Terminal type `sudo nano ~/.bashrc` then on last line add `export JAVA_HOME="<path>"` (paste on <path>). 
   - Press `Ctrl+x` to save and press `y` to confirm.
   - After back to terminal type `source ~/.bashrc` to reload the file so the changes is saved. 

2. **Set `ANDROID_HOME`**:
   - (Optional - if you dont know the path) Open Android Studio (In case you install ANDROID SDK from Android Studio). After that open settings and search Android SDK. Then there will be path to Android SDK, so copy it.
   - Open Terminal and type `sudo nano ~/.bashrc` then on last line add  `export ANDROID_HOME="<path>"` (paste on <path>).
   - Also add the following to the **Path** variable on `~/.bashrc`:
      ```plaintext
      export PATH="$PATH:<ANDROID_HOME_PATH>/platform-tools"
      ```
   - Press `Ctrl+x` to save and press `y` to confirm.
   - After back to terminal type `source ~/.bashrc` to reload the file so the changes is saved.

## Installation and Setup

1. **Clone the Project**:
   Clone the project repository to your local machine.

2. **Configure the Android Driver**:
    - Open the project in IntelliJ IDE.
    - Navigate to `src/main/java/test/android_driver/AndroidDriverInstance.java`.
    - Set up your test app's path and any additional configurations, such as desired capabilities for the device,
      platform, or app under test.

3. **Install Appium and Verify Setup**:
    - Install Appium globally:
      ```bash
      npm install -g appium
      ```
    - Install UIAutomator2:
      ```bash
      appium driver install uiautomator2
      ```
    - Install Appium Doctor globally (Optional):
      ```bash
      npm install appium-doctor -g
      ```
    - Verify installation by starting Appium from the terminal:
      ```bash
      appium
      ```
    - Optionally, use Appium Doctor to ensure the environment is correctly set up:
      ```bash
      appium-doctor
      ```

## Project Structure

- `src/test/resources/features`: Contains the feature files that describe test scenarios in Gherkin format, e.g.,
  `Login.feature`.
- `src/main/java/test/android_driver`: Contains `AndroidDriverInstance.java`, responsible for initializing the Appium
  driver with desired capabilities.
- `src/test/java/step_definitions`: Holds step definitions that link feature file steps to Java code.
- `src/test/java/runners`: Contains test runners for executing feature files.

## Running Tests

To run a test:

1. Open **IntelliJ IDE** and load the project.
2. Ensure the Android emulator is running, or connect a physical Android device.
3. Ensure Test APK is exist in machine and their path are defined on `APP_PATH` inside **.env**.
   - For Windows : It is relative path. Example : `apk/INApas.apk` (Files are stored on `android-test-automation/apk/INApas.apk`).
   - For Linux : It may be ***absolute path***. Example : `../Appium/android-test-automation/apk/INApas.apk` (Files are stored on `../Appium/android-test-automation/apk/INApas.apk`).
   Run Test first to know exactly which case you are.   
4. Navigate to the `src/test/resources/features` directory and locate the feature file you want to execute (e.g.,
   `Login.feature`).
5. Right-click on the feature file and select **Run** to start the test.

## Using Appium Inspector (Optional)

- Use Appium Inspector to inspect your application and select elements by their IDs, XPaths, or other identifiers. This
  tool simplifies locating UI elements for interaction within the test scripts.

## Additional Notes

- Make sure the Appium server is running before executing any tests.
- For debugging environment issues, use **Appium Doctor**.
- Always verify your Android emulator or physical device is connected and ready for testing.

## License
