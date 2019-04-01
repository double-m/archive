#!/bin/bash

set -e

if [ -f modules/custom/manifests/init.pp ]; then
  PUPPET_TARGET='custom'
else
  printf "\nEnter the location of your custom module (ssh of file path) or nothing if you have none\n> "
  read custom_location

  if [ -z "$custom_location" ]; then
    echo "No customization enabled"
    PUPPET_TARGET='all'  
  elif [[ $custom_location == ssh://* ]]; then
    echo "Installing remote custom module..."
    set -x
    mkdir -p modules/custom
    scp -r ${custom_location:6}/* modules/
    PUPPET_TARGET='custom'  
  else
    echo "Installing local custom module..."
    set -x
    mkdir -p modules/custom
    eval EXPANDED_LOCATION=$custom_location/*
    cp -r $EXPANDED_LOCATION modules/custom
    PUPPET_TARGET='custom'  
  fi
fi
  

# test for puppet
set +e
dpkg -s puppet >/dev/null
if [ $? -ne 0 ]; then
   echo "Installing puppet ..."
   set -e
   sudo apt-get -y install puppet
fi

set -e
sudo FACTER_install_gitconfig=$gitconfig \
     FACTER_home=$HOME \
     FACTER_real_id=`whoami` \
     puppet apply --modulepath=modules -e "include $PUPPET_TARGET"
