class custom::composer {

  exec { "install composer":
    require => Class["custom::php"],
    command => "curl -sS https://getcomposer.org/installer | php && \
               sh -c 'mv composer.phar /usr/local/bin/composer'",
    onlyif  => "test ! -f /usr/local/bin/composer",
    path    => [ "/usr/bin", "/bin" ]
  }
}
