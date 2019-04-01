class custom::android {

  package { [ "android-tools-adbd", "android-tools-adbd" ]:
    ensure => "latest"
  }
}
