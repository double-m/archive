## Provisioning of a Node.js service using Vagrant and Ansible

This implementation uses Vagrant and Ansible.

By default, Vagrant creates an Ubuntu server on VirtualBox ad Ansible provisiones it with a Git repository and Node.js, so you can load your Node.js application just doing a `git push`.

The application reacts to changes in its code thanks to `monit`; it automatically come up after VM's reboots thanks to `upstart`.

The application is started using `npm start`, so the `package.json` must include the proper start script.

### 0. Pre-requisites

`vboxheadless`, `vagrant`, `ansible-playbook`

```
$ sudo apt-get install virtualbox vagrant ansible
```

### 1. Start the enviroment

```
$ git clone git@github.com:double-m/nodejs-paas.git
$ cd nodejs-paas/vagrant-ansible
$ vagrant up
```

### 2. Provision the PaaS

```
$ vagrant provision
```

### 3. Push your code to the PaaS

Let's test it using an "Hello World" HTTP application.

First of all, check `http://127.0.0.1:3000` in your web browser: you should see a "Connection reset".

Access the remote machine (`vagrant ssh`) and append your public SSH key to `/home/git/.ssh/authorized_keys`, then:

```
$ git clone ssh://git@127.0.0.1:2222/opt/git/project.git /tmp/project
$ cd /tmp/project
$ cp /PATH/TO/nodejs-paas/vagrant-ansible/test-app/*.js* . # this is an example "Hello World" HTTP application
$ git add -A
$ git commit -am 'first commit'
$ git push
```

Check again `http://127.0.0.1:3000`: now you should see "Hello World" on your browser.

All done!

You can modify the application code, commit it and push it to see the changes. Try a `vagrant reload` to see your app going down and automatically coming up when the reboot is finished.

### Useful commands

Connect to the provisioned box:

```
$ vagrant ssh # or `ssh -p 2222 vagrant@127.0.0.1` with password "vagrant" in Vagrant 1.6
```

Check the Vagrant and VirtualBox files that aren't under version control:

```
$ ls -l ~/.vagrant.d/boxes|grep trusty64
```

### Documentation

[http://docs.vagrantup.com/v2/provisioning/ansible.html](http://docs.vagrantup.com/v2/provisioning/ansible.html)

