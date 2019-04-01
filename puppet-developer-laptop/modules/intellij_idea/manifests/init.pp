class intellij_idea {
  
  # TODO fixme do not download if ${home}/bin/idea is present.. I guess you'll have to resort to an exec with unless
  wget { 'http://download.jetbrains.com/idea/ideaIC-14.0.2.tar.gz'
    destination => '/tmp/.jetbrains.com/idea/ideaIC-14.0.2.tar.gz'
  }
}