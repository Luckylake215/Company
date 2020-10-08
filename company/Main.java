package com.company;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String[] name = {"Max", "Alina", "Anna", "Don", "Brita", "Robert", "Rick", "Dany"};
        final String[] surname = {"Ivanov", "Novicova", "Pushkin", "Smirnova", "Tolstova", "Freeman","Volkov","Egorov"};
        Company company = new Company();
        int baseSalary = 50000;
        for (int i = 0; i < 180; i++) {
            company.hire(new Employee(name[i % 2], surname[i % 4], baseSalary, new Operator()));
        }
        for (int i = 0; i < 80; i++) {
            company.hire(new Employee(name[(i + 2) % 9], surname[(i + 4) % 6], baseSalary, new Manager()));
        }
        for (int i = 0; i < 10; i++) {
            company.hire(new Employee(name[(i + 5) % 9], surname[(i + 3) % 6], baseSalary, new TopManager(company)));
        }

        company.calcProfit();
        System.out.println("Company income: " + company.getProfit());
        outputTopSalary(company, 11);
        outputLowSalary(company, 30);
        System.out.println("Staff list Size");
        for (int i = 0; i < company.getStaffListSize()/2 ; i++) {
            company.fire(i);
        }

        outputTopSalary(company, 15);
        outputLowSalary(company, 30);

    }

    public static void outputTopSalary(Company company, int num) {
        List<Employee> tmp;
        tmp = company.getTopSalaryStaff(num);
        System.out.println("Sort for Top salary");
        for (int i = 0; i < num; i++) {
            System.out.printf(tmp.get(i).getPosition().getJobTitle() + "  ");
            System.out.printf("%,d", (int) tmp.get(i).getPosition().calcSalary(tmp.get(i).getBasicSalary()));
            System.out.println(" rub");
        }
    }
    public static void outputLowSalary(Company company, int num) {
        List<Employee> tmp;
        tmp = company.getLowestSalaryStaff(num);
        System.out.println("Sort for Low salary");
        for (int i = 0; i < num; i++) {
            System.out.printf(tmp.get(i).getPosition().getJobTitle() + "  ");
            System.out.printf("%,d", (int) tmp.get(i).getPosition().calcSalary(tmp.get(i).getBasicSalary()));
            System.out.println(" rub");
        }
    }
}
