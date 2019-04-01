class conky {
  
  package { 'conky' : 
    ensure => 'installed'
  }
  ->
  file { "${home}/.conkyrc":
    ensure => 'present',
    source => "puppet:///modules/${module_name}/conkyrc",
  }
  ->
  file { "${home}/.config/autostart":
    ensure => 'directory'
  }
  ->
  file { "${home}/.config/autostart/conky.desktop":
    ensure => 'present',
    source => "puppet:///modules/${module_name}/conky.desktop",
  }
}