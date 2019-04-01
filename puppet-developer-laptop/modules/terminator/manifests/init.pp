class terminator {
 
  File {
    owner => $real_id,
    group => $read_id,
  }

  package { 'terminator':
    ensure => 'installed'
  }
  ->
  file { "${home}/.config/terminator":
    ensure => 'directory'
  }
  ->
  file { "${home}/.config/terminator/config":
    ensure => 'present',
    source => "puppet:///modules/${module_name}/config",
  }
}