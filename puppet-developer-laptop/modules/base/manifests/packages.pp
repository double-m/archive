# provide basic packages
class base::packages {
  package { ['htop', 'vim', 'meld', 'curl', 'ack-grep', 'tree'] : 
    ensure => installed,
  }
}
