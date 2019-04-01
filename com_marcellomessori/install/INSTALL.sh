#
# 1. read this file carefully
# 2. adjust the configuration to match your needs (at least THIS_PROJECT_DIR)
# 3. remove the following line, launch the scripe (or part of it) and configure a web server
#
echo; echo "Remove this line to execute $0 :)"; echo; exit 1


THIS_PROJECT_DIR=/path/to/this_project
NODE_VERSION=v0.10.32
NODE_VERSION_PLATFORM=$NODE_VERSION-linux-x64



#
# Prerequisites on a CentOS (as root)
#

# install nodejs and npm

sudo su
cd
wget http://nodejs.org/dist/$NODE_VERSION/node-$NODE_VERSION_PLATFORM.tar.gz
cd /usr/local
tar --strip-components 1 -xzf ~/node-$NODE_VERSION_PLATFORM.tar.gz
echo 'export PATH=$PATH:/usr/local/bin' > /etc/profile.d/usr_local_bin.sh
chmod a+x /etc/profile.d/usr_local_bin.sh
/etc/profile.d/usr_local_bin.sh
npm update -g npm

# install grunt
npm install -g grunt-cli

# install bower
npm install -g bower

# install bower
npm install -g yo
npm install -g generator-webapp

# Configure a web server: use $THIS_PROJECT_DIR/public as document root

exit


#
# Working at the project in $THIS_PROJECT_DIR (as an unprivileged user)
#

cd $THIS_PROJECT_DIR
# edit the files in the 'config' dir to match your needs
npm install
bower install # --allow-root
# cp ga_code.txt.dist ga_code.txt && vi ga_code.txt # without --force, the following will fail
grunt build # --force

