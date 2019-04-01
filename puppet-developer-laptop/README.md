# Puppet developer laptop

Provisionment for developer work stations. Similar to [Boxen](https://boxen.github.com/) but focused on Linux rather than Mac OS X.

## Customizations

Customizations are provided in the form of a 'custom' puppet module with the following structure:

    [files]
      + some_file
      + some_other_file
    [manifests]
      + init.pp   # class custom { ... }
      + other.pp  # class custom::other { ... }
    [templates]
      + some_template.erb

For instance your `init.pp` could contain the following in order to setup git:
```puppet      
class custom {

  include all
    
  file { "${home}/.gitconfig":
    source  => "puppet:///modules/${module_name}/.gitconfig",
    require => Package['git'],
    owner => $real_id,
    group => $real_id
  }
}
```

## Running the provisionment

There are two ways to run the provisionment:

 * clone the this repo and run `./install.sh`. This will prompt you to enter 
   So if you enter in the prompt `ssh://toto@my.server.com:~/puppet-laptop-custom` then within `puppet-laptop-custom` you should have
 * copy the `provision` script into a USB stick hosting the various customizations
