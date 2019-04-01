class kupfer {

  apt::source { 'kupfer-team-ppa-saucy': 
    location    => 'http://ppa.launchpad.net/kupfer-team/ppa/ubuntu',
    release     => 'saucy',
    repos       => 'main',
    include_src => true,
    key         => '292F6066',
    key_server  => 'keyserver.ubuntu.com'
  }
  ->
  package { 'kupfer' :
    ensure => 'installed'
  }
}