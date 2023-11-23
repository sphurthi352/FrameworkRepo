pipeline 
{
    agent any

    stages 
{
        stage('Samplejob') 
{
            steps 
{
             build 'samplejob'
            }
        }

        stage('SmokeTest') 
{
            steps 
{		 build 'seleniumTest'	
               

            }
        }



        stage('Regression') 
{
            steps 
{
                build 'seleniumTestTrigger'
		
            }
        }
    }
}
