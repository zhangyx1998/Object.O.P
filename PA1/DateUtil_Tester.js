const colors = require('colors');
const { exec } = require('child_process');
// colors.disable();

class dateTester {
    constructor() {
        this.Year = 1;
        this.Month = 1;
        this.Day = 1;
    }

    get date() {
        return new Date(Date.parse(
            [
                this.Year.toString().padStart(4, '0'),
                this.Month.toString().padStart(2, '0'),
                this.Day.toString().padStart(2, '0')
            ].join('-') + 'T00:00:00.0000Z'
        ))
    }

    proof() {
        var date = this.date;
        // Step one day forward
        this.Day++;
        if (this.Day > 32) {
            this.Day = 1;
            this.Month++;
            if (this.Month > 13) {
                this.Year++;
            }
        }
        if (date instanceof Date && !isNaN(date)) {
            return {
                DayOfWeek: date.getDay()
            }
        } else {
            return undefined
        }
    }

    render() {
        return [
            this.Year.toString().padStart(4, '0'),
            this.Month.toString().padStart(2, '0'),
            this.Day.toString().padStart(2, '0')
        ].join('-')
    }
}

class ConsoleMaintainer {
    CurrentString = '';
    constructor() { }
    update(NewString) {
        process.stdout.clearLine(0);
        process.stdout.cursorTo(0);
        process.stdout.write(NewString);
        return;
        // --------------------------------------------------------------------------------
        var i = NewString.length - 1, j = 0;
        process.stdout.cursorTo(i);
        if (NewString.length < this.CurrentString.length) {
            process.stdout.clearLine(1);
        }
        while (j <= i) {
            process.stdout.cursorTo(j);
            if (j >= this.CurrentString.length || this.CurrentString[j] !== NewString[j]) {
                process.stdout.write(NewString[j])
            }
            j++;
        }
        this.line = NewString;
        process.stdout.cursorTo(this.line.length);
    }
    append(NewString) {
        process.stdout.write(NewString);
        return;
        // ----------------------------------------
        process.stdout.cursorTo(this.line.length);
        process.stdout.write(NewString);
        this.line += NewString;
    }
    println(NewString) {
        process.stdout.write(NewString + '\n');
        return;
        process.stdout.cursorTo(this.line.length);
        process.stdout.write('\n');
        process.stdout.write(NewString);
        this.line = NewString;
    }
    get line() { return this.CurrentString }
    set line(str) {
        this.CurrentString = str.split('\n').reverse()[0];
    }
}

var tester = new dateTester(),
    maintainer = new ConsoleMaintainer(),
    result_buf = "";

function test_next() {
    if (tester.Year < 2) {
        maintainer.update('Testing '.bold + tester.render().yellow + ': ' + result_buf);
        exec(`java DateUtil_Dump ${tester.Year} ${tester.Month} ${tester.Day}`, (_err, stdout, _stderr) => {
            var std, out;
            try {
                std = tester.proof();
                out = JSON.parse(stdout);
                if (!out.Valid || std === undefined) {
                    if (!(!out.Valid && std === undefined)) {
                        maintainer.update('Testing '.bold + tester.render().yellow + ': ' + 'Disagree'.red + ` [ ${out.Valid} | ${!(std === undefined)} ]`);
                        maintainer.println('');
                    } else
                        result_buf = 'Agree'.green + ' [Invalid]'.gray;
                } else {
                    if (out.DayOfWeek === std.DayOfWeek)
                        result_buf = 'Agree'.green + ` [ ${out.Formatted} ]`.gray;
                    else {
                        maintainer.update('Testing '.bold + tester.render().yellow + ': ' + 'Disagree'.red + ` [ ${out.DayOfWeek} | ${std.DayOfWeek} ]`);
                        maintainer.println('');
                    }
                }
                test_next();
            } catch (error) {
                console.log(stdout);
                process.exit;
            }
        });
    } else {
        maintainer.update('Done.\n'.green.bold);
    }
}

test_next();