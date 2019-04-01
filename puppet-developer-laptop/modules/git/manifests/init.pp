class git {
  
  package { ['git', 'git-gui', 'gitk']: 
    ensure => 'installed'
  }
}
