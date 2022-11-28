import time

from selenium import webdriver
import unittest
import HtmlTestRunner
from selenium.webdriver import Keys
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from webdriver_manager.core.utils import ChromeType



class PasswordGeneratorTest(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.driver = webdriver.Chrome(ChromeDriverManager(chrome_type=ChromeType.CHROMIUM).install())
        cls.driver.maximize_window()

    def test_passwordGenerateTitle(self):
        self.driver.get("https://passwordgenratoooor.netlify.app/")
        self.assertEqual("PASSWORD GENERATOR", self.driver.title, "Web title is not matching")

    def test_generatePassword(self):
        self.driver.get("https://passwordgenratoooor.netlify.app/")
        self.driver.find_element("xpath", "//input[@id='len']").click()
        time.sleep(10)
        self.driver.find_element("xpath", "//input[@id='len']").send_keys(Keys.BACK_SPACE)
        self.driver.find_element("xpath","//input[@id='len']").send_keys("5")
        self.driver.find_element("xpath","//input[@id='upper']").click()
        self.driver.find_element("xpath","//input[@id='lower']").click()
        self.driver.find_element("xpath","//input[@id='number']").click()
        self.driver.find_element("xpath","//input[@id='symbol']").click()
        #Generate password with upper, lower, symbol and numbers
        self.driver.find_element("xpath","//button[@id='generate']").click()
        #Generated password
        passwordGenerated = self.driver.find_element("xpath","//div[@id='pw']").text
        print("Password generated : " +passwordGenerated)

    @classmethod
    def tearDownClass(cls):
        cls.driver.quit()
        print("Test Completed.....!!!!")

if __name__=='__main__':
    unittest.main(testRunner=HtmlTestRunner.HTMLTestRunner(output='C:\\Users\\Gokul A\\PycharmProjects\\SeleniumFramework\\reports'))