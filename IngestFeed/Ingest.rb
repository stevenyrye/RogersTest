# Comment to Robert Lan:
# to run this should have all required libs to be installed first
# this script test at irb console, since my OS X upgraded to the
# latest version, Ruby plugin for eclipse was never worked properly and looks like hard to
# fix it in short term, now only thing can be done is via irb
#
require 'awesome_print'
require 'json'
require 'httparty'
require "crack"
require 'mysql'


# get feeds, body is xml
feed = HTTParty.get('http://www.macleans.ca/multimedia/feed/')
feedXML = feed.body

# save xml to a file as the result for test check
File.open('/Users/steven_yrye/feed.xml', 'w') do |f|
  f.puts feedXML  
end

# convert body to json format
crackXML = Crack::XML.parse(feedXML)
feedJSON = crackXML.to_json

# save json to a file as the result for test check
File.open('/Users/steven_yrye/feed.json', 'w') do |f1|
  f1.puts feedJSON  
end

# Comment to Robert Lan:
# MySql @ my iMac was not work properly, the following DB code is
# not tested. I'm thinking because of the feeds usually big
# maybe we should BLOB type @ DB table
#
# put into database (here mySql for example) table FEEDS (columns = id, XML_FEED, JSON_FEED)
con = Mysql.new 'localhost', 'steven_yrye', 'fakepass'
pst = con.prepare "INSERT INTO FEEDS (XML_FEED, JSON_FEED) VALUES(?,?)"
pst.execute feedXML, feedJSON
con.commit
pst.close
con.close