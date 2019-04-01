class custom::vim_plugins {

  file { ".vimrc":
    path   => "${home}/.vimrc",
    ensure => "file",
    owner  => $real_id,
    group  => $real_id,
    mode   => 644
  }
  ->
  file_line { ".vimrc content":
    path => "${home}/.vimrc",
    line => "execute pathogen#infect()"
  }
  ->
  file { [ "${home}/.vim/autoload", "${home}/.vim/bundle" ]:
    ensure => "directory",
    owner  => $real_id,
    group  => $real_id,
    mode   => 750
  }
  ->
  exec { "install pathogen for vim":
    command => "curl -LSso ${home}/.vim/autoload/pathogen.vim https://tpo.pe/pathogen.vim",
    onlyif  => "test ! -f ${home}/.vim/autoload/pathogen.vim",
    path    => "/usr/bin"
  }
  ->
  exec { "install systastic for vim via pathogen":
    command => "git clone https://github.com/scrooloose/syntastic.git && \
                sh -c 'mv syntastic ${home}/.vim/bundle'",
    onlyif  => "test ! -d ${home}/.vim/bundle/syntastic",
    path    => [ "/usr/bin", "/bin" ]
  }
  ->
  exec { "install vim-puppet":
    command => "git clone git://github.com/rodjek/vim-puppet.git && \
                sh -c 'mv vim-puppet ${home}/.vim/bundle'",
    onlyif  => "test ! -d ${home}/.vim/bundle/vim-puppet",
    path    => [ "/usr/bin", "/bin" ]
  }
  ->
  exec { "fix permissions on ~/.vim":
    command => "sh -c 'chown -R $real_id:$real_id ${home}/.vim'", 
    path    => "/bin"
  }
}
