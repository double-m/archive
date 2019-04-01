class custom::symfony {

  exec { "symfony installer":
    command => "curl -LsS http://symfony.com/installer -o /usr/local/bin/symfony && \
               chmod a+x /usr/local/bin/symfony",
    onlyif  => "test ! -f /usr/local/bin/symfony",
    path    => [ "/usr/bin", "/bin" ]
  }
}
