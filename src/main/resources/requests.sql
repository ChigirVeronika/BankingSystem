select user.*,
accommodationcity.name as accommodationcity,
registrationcity.name as registrationcity,
maritalstatus.type as maritalstatus,
citizenship.name as citizenship,
disability.type as disability
from banking.user
left join banking.accommodationcity on user.accommodationcity_id=accommodationcity.id
left join banking.registrationcity on user.registrationcity_id=registrationcity.id
left join banking.maritalstatus on user.maritalstatus_id=maritalstatus.id
left join banking.citizenship on user.citizenship_id=citizenship.id
left join banking.disability on user.disability_id=disability.id ORDER BY user.lastname ASC;

SELECT * FROM banking.user ORDER BY lastname ASC;

INSERT INTO `banking`.`user`"+
            "(`firstname`,`middlename`,`lastname`,`birthday`,`gender`,`passportseries`,`passportnumber`,"+
            "`whomgranted`,`granteddate`,`idnumber`,`birthplace`,`accommodationcity_id`,`accommodationaddres`,"+
            "`homephone`,`cellphone`,`email`,`workplace`,`position`,`registrationcity_id`,`maritalstatus_id`,"+
            "`citizenship_id`,`disability_id`,`pensioner`,`monthincome`)"+
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);