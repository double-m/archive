class custom::git {

  file { "${home}/.gitconfig" :
    ensure => "file",
    owner  => $real_id,
    group  => $real_id,
    mode   => 644
  }
  ->
  exec { "set the email globally" :
    command => "git config --global user.email \"marcello.mm.messori@gmail.com\"",
    environment => ["HOME=${home}"],
    path => "/usr/bin"
  }
  ->
  exec { "set the name globally" :
    command => "git config --global user.name \"Marcello Messori\"",
    environment => ["HOME=${home}"],
    path => "/usr/bin"
  }
  ->
  exec { "generate an alias for a fancy git log" :
    command => "/usr/bin/git config --global alias.lg \"log --color --graph --pretty=format:'%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset' --abbrev-commit\"",
    environment => ["HOME=${home}"],
    path => "/usr/bin"
  }
}
