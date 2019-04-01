class fish {
  include apt
  include fish::config

  File {
    owner => $real_id,
    group => $real_id
  }

  apt::source { 'fish-shell-release-2': 
    location    => 'http://ppa.launchpad.net/fish-shell/release-2/ubuntu',
    release     => 'trusty',
    repos       => 'main',
    include_src => true,
    key         => '6DC33CA5',
    key_server  => 'keyserver.ubuntu.com'
  }
  ->
  package { 'fish' :
    ensure => 'installed'
  }
  ->
  # install fish as the default shell
  user { $real_id:
    ensure => present,
    shell  => "/usr/bin/fish",
  }
  ->
  file { "${home}/.config/fish":
    ensure => 'directory'
  }
  ->
  file { "${home}/.config/fish/functions":
    ensure => 'directory'
  }
  ->
  file { "${home}/.config/fish/functions/fish_prompt.fish":
    ensure  => 'present',
    source  => "puppet:///modules/${module_name}/fish_prompt.fish",
  }
  ->
  file { '/usr/share/fish/functions/fish_default_key_bindings.fish':
    ensure => present,
    source  => "puppet:///modules/${module_name}/default_key_bindings.fish",
    owner => 'root',
    group => 'root',
    mode  => '0644'
  }
}
