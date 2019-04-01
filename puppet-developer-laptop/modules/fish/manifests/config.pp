class fish::config {

  $target = "${home}/.config/fish/config.fish"

  concat { $target:
    ensure => present,
    owner => $real_id,
    group => $real_id
  }  
  fish::add_config { 'default':
    source => "puppet:///modules/${module_name}/config.fish",
    order  => '01'
  }
}

define fish::add_config($content = undef,
                        $source = "puppet:///modules/${caller_module_name}/$name",
                        $order = '02') {

  if $content != undef {
    $da_source = undef
  } else {
    $da_source = $source
  }

  concat::fragment { $name:
    target  => $fish::config::target,
    content => $content,
    source  => $da_source,
    order   => $order
  }
}