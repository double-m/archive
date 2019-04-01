class custom::composer_packages {

  $user_profile = "${home}/.profile"
  exec { "update PATH adding composer's vendor's binaries":
    require => Class["custom::composer"],
    command => "echo >> ${home}/.profile && \
                echo '# update PATH adding composer\'s vendor\'s binaries' >> ${home}/.profile && \
                echo 'PATH=\"\$PATH:\$HOME/.composer/vendor/bin\"' >> ${home}/.profile",
    unless => "grep -qe 'composer' -- $user_profile",
    path => "/bin"
  }

  exec { "install php_codesniffer via composer":
    require => Class["custom::composer"],
    command => 'composer global require "squizlabs/php_codesniffer=*"',
    unless => "grep -qe 'squizlabs/php_codesniffer' -- ${home}/.composer/composer.json",
    path    => [ "/bin", "/usr/bin", "/usr/local/bin" ],
    environment => ["COMPOSER_HOME=${home}/.composer"],
    logoutput => true
  }
  ->
  exec { "install robo via composer":
    require => Class["custom::composer"],
    command => 'composer global require codegyre/robo',
    unless => "grep -qe 'codegyre/robo' -- ${home}/.composer/composer.json",
    path    => [ "/bin", "/usr/bin", "/usr/local/bin" ],
    environment => ["COMPOSER_HOME=${home}/.composer"],
    logoutput => true
  }
  ->
  exec { "fix permissions on ~/.composer":
    command => "sh -c 'chown -R $real_id:$real_id ${home}/.composer'",
    path    => "/bin"
  }
}
